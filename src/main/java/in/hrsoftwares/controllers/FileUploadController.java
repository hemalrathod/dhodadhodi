package in.hrsoftwares.controllers;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/File")
public class FileUploadController {
	@Autowired
	ServletContext context;
	@RequestMapping(method = RequestMethod.GET)
	public String Index(HttpSession s, ModelMap m) {
		return "File/Index";
	}

	@RequestMapping(value = "/Upload", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(HttpServletRequest request,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Create the file on server
				File serverFile = new File(request.getSession().getServletContext().getRealPath("/WEB-INF/"), file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				return "You successfully uploaded file";
			} catch (Exception e) {
				return "You failed to upload " + e.getMessage();
			}
		} else {
			return "You failed to upload because the file was empty.";
		}
	}
}

package pc01815.Normal_J6.Util;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	
	private static String generateRandomPassword(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
          +"lmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
	public void saveFile(MultipartFile file, ServletContext test) throws IllegalStateException, IOException {
		if(!file.isEmpty()) {
			String getFile = file.getOriginalFilename();
			String getExtension = FilenameUtils.getExtension(getFile);
			String filenamnRandom = generateRandomPassword(20);
			String filename = filenamnRandom + "." + getExtension;
			
			File saveFile = new File(test.getRealPath("/docs/" + filename));
			file.transferTo(saveFile);
		}
	}
}

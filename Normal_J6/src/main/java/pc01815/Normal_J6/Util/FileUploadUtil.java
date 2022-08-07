package pc01815.Normal_J6.Util;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	
	private static String generateRandomName(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
          +"lmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
	public void saveFile(MultipartFile file, ServletContext app) throws IllegalStateException, IOException {
		if(!file.isEmpty()) {
			String getFile = file.getOriginalFilename();
			String getExtension = FilenameUtils.getExtension(getFile);
			String filenamnRandom = generateRandomName(20);
			String filename = filenamnRandom + "." + getExtension;
			
			File saveFile = new File(app.getRealPath("/imgProducts/" + filename));
			file.transferTo(saveFile);
		}else {
			File getDefaulImg = new File(app.getRealPath("/defaulImgProducts/default.png"));
			String getExtenstionOfDefault = FilenameUtils.getExtension(getDefaulImg.getName());
			String rdFileName = generateRandomName(20);
			String fileDefault = rdFileName + "." + getExtenstionOfDefault;
			File saveFile = new File(app.getRealPath("/imgProducts/" + fileDefault));
			FileUtils.copyFile(getDefaulImg, saveFile);
//			System.err.println(getExtenstionOfDefault);
//			System.err.println("đang null");
		}
	}
}

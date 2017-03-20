package fileinfo.utilities;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fileinfo.attributes.FileAttributes;
import fileinfo.attributes.PathSizeDirAttributes;

@Component
public class JSONConerter {
	Gson objGson = new GsonBuilder().setPrettyPrinting().create();

	/**
	 * 
	 * @param fileAttributes
	 * @return
	 */
	public String convertFileAttributesToJson(List<FileAttributes> fileAttributes) {
		return objGson.toJson(fileAttributes);
	}

	/**
	 * 
	 * @param fileAttributes
	 * @return
	 */
	public String convertPathSizeAndIsDirAttributesToJson(List<PathSizeDirAttributes> fileAttributes) {
		return objGson.toJson(fileAttributes);
	}

}

package fileinfo.controller;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fileinfo.FileInformationFetcher;
import fileinfo.FileInformationFetcherImpl;
import fileinfo.utilities.JSONConerter;

/**
 * Controller class
 * 
 * @author Ajay
 *
 */
@RestController
public class FileController {

	static FileInformationFetcher fileSearch = new FileInformationFetcherImpl();
	static JSONConerter jSONConerter = new JSONConerter();

	static boolean verifyValidPath(String path) throws InvalidPathException, NullPointerException {
		Path validPath = Paths.get(path);
		return true;
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	@RequestMapping(value = "/api/v1/filedetails/", method = RequestMethod.GET)
	@ResponseBody
	public static String getAllFileDetails(@RequestParam("path") String path) {
		try {
			System.out.println("getAllFileDetails ::: " + path);
			verifyValidPath(path);
			System.out.println("getAllFileDetails verified path ::: " + path);
			return jSONConerter.convertFileAttributesToJson(fileSearch.fetchAllFileDetails(path));
		} catch (Exception ex) {
			return " Error Occured : " + ex.toString();
		}

	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	@RequestMapping(value = "/api/v1/pathsizeandisdirectorydetails/", method = RequestMethod.GET)
	@ResponseBody
	public static String getPathSizeAndIsDirDetails(@RequestParam("path") String path) {
		try {
			System.out.println("getPathSizeAndIsDirDetails ::: " + path);
			verifyValidPath(path);
			return jSONConerter.convertPathSizeAndIsDirAttributesToJson(fileSearch.fetchPathSizeAndIsFileDetails(path));
		} catch (Exception ex) {
			return " Error Occured : " + ex.toString();
		}
	}
}

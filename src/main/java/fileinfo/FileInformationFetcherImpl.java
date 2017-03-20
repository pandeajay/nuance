package fileinfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import fileinfo.FileInformationFetcher;
import fileinfo.attributes.FileAttributes;
import fileinfo.attributes.PathSizeDirAttributes;

@Component
public class FileInformationFetcherImpl implements FileInformationFetcher {

	static List<Path> getAllFiles(String searchPath) throws IOException {
		return Files.walk(new File(searchPath).toPath()).collect(Collectors.toList());
	}

	@Override
	public List<PathSizeDirAttributes> fetchPathSizeAndIsFileDetails(String file) throws IOException {
		List<PathSizeDirAttributes> filesAttributes = new ArrayList<PathSizeDirAttributes>();
		for (Path path : getAllFiles(file)) {
			BasicFileAttributeView bv = Files.getFileAttributeView(path, BasicFileAttributeView.class);
			filesAttributes.add(constructPathSizeAndIsFileDetails(bv, path.toString()));
		}
		return filesAttributes;
	}

	@Override
	public List<FileAttributes> fetchAllFileDetails(String file) throws IOException {
		List<FileAttributes> filesAttributes = new ArrayList<FileAttributes>();
		for (Path path : getAllFiles(file)) {
			BasicFileAttributeView bv = Files.getFileAttributeView(path, BasicFileAttributeView.class);
			filesAttributes.add(constructAllFileDetails(bv, path.toString()));
		}
		return filesAttributes;
	}

	static PathSizeDirAttributes constructPathSizeAndIsFileDetails(BasicFileAttributeView bv, String fileName)
			throws IOException {
		PathSizeDirAttributes fileAttributes = new PathSizeDirAttributes();
		fileAttributes.setFullPath(fileName);
		fileAttributes.setDirectory(bv.readAttributes().isDirectory());
		fileAttributes.setSize(bv.readAttributes().size());
		return fileAttributes;
	}

	static FileAttributes constructAllFileDetails(BasicFileAttributeView bv, String fileName) throws IOException {
		FileAttributes fileAttributes = new FileAttributes();
		fileAttributes.setFileName(fileName);
		fileAttributes.setCreationTime(bv.readAttributes().creationTime().toMillis());
		fileAttributes.setDirectory(bv.readAttributes().isDirectory());
		fileAttributes.setRegularFile(bv.readAttributes().isRegularFile());
		fileAttributes.setSymbolicLink(bv.readAttributes().isSymbolicLink());
		fileAttributes.setLastAccessTime(bv.readAttributes().lastAccessTime().toMillis());
		fileAttributes.setLastModifiedTime(bv.readAttributes().lastModifiedTime().toMillis());
		fileAttributes.setSize(bv.readAttributes().size());
		fileAttributes.setOther(bv.readAttributes().isOther());
		return fileAttributes;
	}

	public static void main(String args[]) throws IOException {

		for (Path path : getAllFiles("C:\\temp\\")) {
			System.out.println("File Path ::: " + path);
			/*
			 * AclFileAttributeView view = Files.getFileAttributeView(path,
			 * AclFileAttributeView.class); if (view != null) { List<AclEntry>
			 * acls = view..getAcl(); for (AclEntry acl : acls) {
			 * System.out.println(acl.principal().getName() + ":" + acl.type());
			 * } }
			 */
			System.out.println("");
			System.out.println("");

		}
	}

}

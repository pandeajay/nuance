package fileinfo.attributes;

import fileinfo.attributes.PathSizeDirAttributes;

public class FileAttributes extends PathSizeDirAttributes {
	Long creationTime;
	boolean isRegularFile;
	boolean isSymbolicLink;
	long lastAccessTime;
	long lastModifiedTime;

	boolean isOther;

	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "FileAttributes [creationTime=" + creationTime + ", isRegularFile=" + isRegularFile + ", isSymbolicLink="
				+ isSymbolicLink + ", lastAccessTime=" + lastAccessTime + ", lastModifiedTime=" + lastModifiedTime
				+ ", isOther=" + isOther + "]";
	}

	public boolean isDirectory() {
		return isDirectory;
	}

	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}

	public boolean isRegularFile() {
		return isRegularFile;
	}

	public void setRegularFile(boolean isRegularFile) {
		this.isRegularFile = isRegularFile;
	}

	public boolean isSymbolicLink() {
		return isSymbolicLink;
	}

	public void setSymbolicLink(boolean isSymbolicLink) {
		this.isSymbolicLink = isSymbolicLink;
	}

	public long getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public long getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public boolean isOther() {
		return isOther;
	}

	public void setOther(boolean isOther) {
		this.isOther = isOther;
	}

	public void setFileName(String fileName) {
		// TODO Auto-generated method stub
		super.setFullPath(fileName);

	}

	public String getFileName() {
		return super.getFullPath();
	}

}

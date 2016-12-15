package cat.david.album.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="albfolder")
public class Folder extends Device {

	private List<Folder> folders;
	private List<File> 	 files;
	
	@OneToMany(targetEntity=Folder.class, mappedBy="parent", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<Folder> getFolders() {
		return folders;
	}
	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}

	@OneToMany(targetEntity=File.class, mappedBy="parent", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<File> getFiles() {
		return files;
	}
	public void setFiles(List<File> files) {
		this.files = files;
	}


	
}

package playlistRefactor;

import java.util.*;

public class Album {
	
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        return songs.findSong(title);
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber -1;
        if((index > 0) && (index <= songs.getSongs().size())) {
            playList.add(songs.getSongs().get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
    
    private class SongList{
    	
    	private ArrayList<Song> songs;
    	
    	public SongList(){
    		songs = new ArrayList<Song>();
    	}
    	
    	private ArrayList<Song> getSongs(){
    		return songs;
    	}
    	
    	private void add(Song song){
    		songs.add(song);
    	}
    	
    	private Song findSong(String title){
    		for(Song checkedSong: getSongs()) {
                if(checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
    	}
    }
}

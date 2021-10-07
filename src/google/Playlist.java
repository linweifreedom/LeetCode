package google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Playlist {
	List<String> songs;
	Queue<String> waitQueue;
	int k;
	public Playlist(String[] songs, int k) {
		this.songs = new ArrayList<>();
		for (String song : songs) this.songs.add(song);
		this.k = k;
		waitQueue = new LinkedList<>();
	}
	
	public String getNextSongs() {
		Random random = new Random();
		int nextSongIndex = random.nextInt(songs.size());
		String nextSong = songs.get(nextSongIndex);
		songs.remove(nextSongIndex);
		waitQueue.offer(nextSong);
		if (waitQueue.size() > k)
			songs.add(waitQueue.poll());
		return nextSong;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] songs = {"A", "b", "CC", "SD", "REW" , "ASFAS", "ASDF", "FSDFA"};
		Playlist playlist = new Playlist(songs, 4);
		for (int i = 0; i < 20; i++) {
			System.out.println(playlist.getNextSongs());
		}

	}

}

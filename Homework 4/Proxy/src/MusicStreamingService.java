import java.util.ArrayList;
import java.util.List;

public class MusicStreamingService implements SongService {
    private List<Song> library;

    public MusicStreamingService(List<Song> library) {
        this.library = library;
    }

    private void timeDelay() {
        try { Thread.sleep(3000); }
        catch (Exception e) {}
    }

    @Override
    public Song searchById(Integer songID) {
        timeDelay();
        Song searchResult = null;
        for (Song song: library)
            if (song.getId().equals(songID))
                searchResult = song;
        return searchResult;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        timeDelay();
        List<Song> searchResults = new ArrayList<>();
        for (Song song: library)
            if (song.getTitle().toLowerCase().contains(title.toLowerCase()))
                searchResults.add(song);
        return searchResults;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        timeDelay();
        List<Song> searchResults = new ArrayList<>();
        for (Song song: library)
            if (song.getTitle().toLowerCase().contains(album.toLowerCase()))
                searchResults.add(song);
        return searchResults;
    }
}

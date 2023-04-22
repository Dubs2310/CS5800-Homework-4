import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxyService implements SongService {
    private SongService streamingService;
    private Map<Integer, Song> songCache = new HashMap<>();
    private Map<String, List<Song>> titleSearchCache = new HashMap<>();
    private Map<String, List<Song>> albumSearchCache = new HashMap<>();

    public ProxyService(SongService streamingService) {
        this.streamingService = streamingService;
    }

    // Check song cache if songID is present, otherwise retrieve song from the streaming service
    @Override
    public Song searchById(Integer songID) {
        Song searchResult;
        if (songCache.containsKey(songID))
            searchResult = songCache.get(songID);
        else {
            searchResult = streamingService.searchById(songID);
            songCache.put(songID, searchResult);
        }
        return searchResult;
    }

    private void putSongsInCache(List<Song> songs) {
        if (songs.size() == 0) return;
        for (Song song: songs) {
            Integer songID = song.getId();
            if (!songCache.containsKey(songID))
                songCache.put(songID, song);
        }
    }

    // Check titleSearchCache is search was done before, else get list from streaming service
    // Add songs to songCache for future use
    @Override
    public List<Song> searchByTitle(String title) {
        List<Song> searchResults;
        if (titleSearchCache.containsKey(title))
            searchResults = titleSearchCache.get(title);
        else {
            searchResults = streamingService.searchByTitle(title);
            titleSearchCache.put(title, searchResults);
        }
        putSongsInCache(searchResults);
        return searchResults;
    }

    // Check albumSearchCache is search was done before, else get list from streaming service
    // Add songs to songCache for future use
    @Override
    public List<Song> searchByAlbum(String album) {
        List<Song> searchResults;
        if (albumSearchCache.containsKey(album))
            searchResults = albumSearchCache.get(album);
        else {
            searchResults = streamingService.searchByAlbum(album);
            albumSearchCache.put(album, searchResults);
        }
        putSongsInCache(searchResults);
        return searchResults;
    }
}

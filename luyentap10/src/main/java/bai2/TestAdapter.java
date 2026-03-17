package bai2;

public class TestAdapter {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.play("mp3", "song.mp3");
        player.play("vlc", "movie.vlc");
        player.play("mp4", "video.mp4");
    }
}

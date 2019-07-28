package demo27;

public class MockSystemEnvironment implements Environmental {
	public long getTime() {
		return current_time;
	}

	public void setTime(long aTime) {
		current_time = aTime;
	}

	private long current_time;

	public void playWavFile(String filename) {
		playedWav = true;
	}

	public boolean wavWasPlayed() {
		return playedWav;
	}

	public void resetWav() {
		playedWav = false;
	}

	private boolean playedWav = false;

	// ...
}

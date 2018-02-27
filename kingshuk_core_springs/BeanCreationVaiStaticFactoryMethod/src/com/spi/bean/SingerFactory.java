package com.spi.bean;

public class SingerFactory {
	public static synchronized Singer createSinger(final String song) {
		Singer singer = new Singer();
		singer.setSong(song);
		return singer;
	}
}

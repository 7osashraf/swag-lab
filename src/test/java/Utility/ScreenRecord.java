package Utility;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;


public class ScreenRecord extends screenShot{
	private static ScreenRecorder screenRecorder;

	// Start recording method
	public static ScreenRecorder startRecording(String fileName)
			throws IOException, AWTException {
		// Get user directory and create a folder for recordings
		String userDir = System.getProperty("user.dir");
		File file = new File(userDir + "/ScreenRecording/" + fileName);

		if (!file.exists()) {
			file.mkdirs();
		}

		// Set up screen configuration for recording
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		screenRecorder = new ScreenRecorder(gc,
			    null, new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
			    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
			        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
			        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
			    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
			    null, file);

		screenRecorder.start();

		System.out.println("Screen recording started for: " + fileName);
		return screenRecorder;
	}

	// Stop recording method
	public static void stopRecording() throws IOException {
		if (screenRecorder != null) {
			screenRecorder.stop();
			System.out.println("Screen recording stopped.");
		} else {
			System.out.println("No screen recorder found.");
		}
	}

	// Get current timestamp to be used in file naming
	public static String getCurrentTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	}
}

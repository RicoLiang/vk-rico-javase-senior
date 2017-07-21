package vk.rico.javase.senior.bean.util.jackson;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.Deflater;

import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipParameters;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.xerial.snappy.Snappy;

/**
 * 压缩/解压缩工具类
 * 
 * @author liangxf
 *
 */
public class CompressUtils {

	private static final String ENCODING_UTF_8 = "UTF-8";
	private GzipParameters gzipParameters;

	public CompressUtils() {
		gzipParameters = new GzipParameters();
		gzipParameters.setCompressionLevel(Deflater.BEST_COMPRESSION);
	}

	/**
	 * gzip压缩
	 * 
	 * @param data
	 * @return gzip压缩后的字节数组
	 * @throws IOException
	 */
	public byte[] compressGzip(byte[] data) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		GzipCompressorOutputStream gzipOutput = null;
		try {
			gzipOutput = new GzipCompressorOutputStream(outputStream, gzipParameters);
			IOUtils.copyLarge(new ByteArrayInputStream(data), gzipOutput);
		} finally {
			IOUtils.closeQuietly(gzipOutput);
		}
		return outputStream.toByteArray();
	}

	/**
	 * gzip解压
	 * 
	 * @param data
	 * @param encoding
	 *            字符串编码，默认是UTF-8
	 * @return gzip解压后经过encoding编码的字符串
	 * @throws IOException
	 */
	public String uncompressGzip(byte[] data, String encoding) throws IOException {
		encoding = StringUtils.isBlank(encoding) ? ENCODING_UTF_8 : encoding;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		GzipCompressorInputStream gzipInput = null;
		try {
			gzipInput = new GzipCompressorInputStream(new ByteArrayInputStream(data), true);
			IOUtils.copyLarge(gzipInput, outputStream);
		} finally {
			IOUtils.closeQuietly(gzipInput);
		}
		return IOUtils.toString(outputStream.toByteArray(), encoding);
	}

	public byte[] compressSnappy(byte[] data) throws IOException {
		return Snappy.compress(data);
	}

	public byte[] compressSnappy(String content, String encoding) throws IOException {
		encoding = StringUtils.isBlank(encoding) ? ENCODING_UTF_8 : encoding;
		return Snappy.compress(content, encoding);
	}

	public String uncompressSnappy(byte[] data, String encoding) throws IOException {
		encoding = StringUtils.isBlank(encoding) ? ENCODING_UTF_8 : encoding;
		return Snappy.uncompressString(data, 0, data.length, encoding);
	}

	public byte[] compressXz(byte[] data) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		XZCompressorOutputStream xzOutput = null;
		try {
			xzOutput = new XZCompressorOutputStream(outputStream);
			IOUtils.copyLarge(new ByteArrayInputStream(data), xzOutput);
		} finally {
			IOUtils.closeQuietly(xzOutput);
		}
		return outputStream.toByteArray();
	}

	public String uncompressXz(byte[] data, String encoding) throws IOException {
		encoding = StringUtils.isBlank(encoding) ? ENCODING_UTF_8 : encoding;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		XZCompressorInputStream xzInput = null;
		try {
			xzInput = new XZCompressorInputStream(new ByteArrayInputStream(data), true);
			IOUtils.copyLarge(xzInput, outputStream);
		} finally {
			IOUtils.closeQuietly(xzInput);
		}
		return IOUtils.toString(outputStream.toByteArray(), encoding);
	}

	public byte[] compressBzip2(byte[] data) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		BZip2CompressorOutputStream bzip2Output = null;
		try {
			bzip2Output = new BZip2CompressorOutputStream(outputStream);
			IOUtils.copyLarge(new ByteArrayInputStream(data), bzip2Output);
		} finally {
			IOUtils.closeQuietly(bzip2Output);
		}
		return outputStream.toByteArray();
	}

	public String uncompressBzip2(byte[] data, String encoding) throws IOException {
		encoding = StringUtils.isBlank(encoding) ? ENCODING_UTF_8 : encoding;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		BZip2CompressorInputStream bzip2Input = null;
		try {
			bzip2Input = new BZip2CompressorInputStream(new ByteArrayInputStream(data), true);
			IOUtils.copyLarge(bzip2Input, outputStream);
		} finally {
			IOUtils.closeQuietly(bzip2Input);
		}
		return IOUtils.toString(outputStream.toByteArray(), encoding);
	}

	public byte[] compressZip(byte[] data) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		ZipArchiveOutputStream zipOutput = null;
		try {
			zipOutput = new ZipArchiveOutputStream(outputStream);
			IOUtils.copyLarge(new ByteArrayInputStream(data), zipOutput);
		} finally {
			IOUtils.closeQuietly(zipOutput);
		}
		return outputStream.toByteArray();
	}

	public String uncompressZip(byte[] data, String encoding) throws IOException {
		encoding = StringUtils.isBlank(encoding) ? ENCODING_UTF_8 : encoding;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		ZipArchiveInputStream zipInput = null;
		try {
			zipInput = new ZipArchiveInputStream(new ByteArrayInputStream(data));
			IOUtils.copyLarge(zipInput, outputStream);
		} finally {
			IOUtils.closeQuietly(zipInput);
		}
		return IOUtils.toString(outputStream.toByteArray(), encoding);
	}
}

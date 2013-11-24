package com.beans;

public class OutputBean {

	private String os;
	private String inputFile;
	private double estimatedTime;
	private String outputFilename;
	private String machineId;
	private long memoryAllocated;

	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public long getMemoryAllocated() {
		return memoryAllocated;
	}
	public void setMemoryAllocated(long memoryAllocated) {
		this.memoryAllocated = memoryAllocated;
	}
	public String getOutputFilename() {
		return outputFilename;
	}
	public void setOutputFilename(String outputFilename) {
		this.outputFilename = outputFilename;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public double getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(double estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	public String getInputFile() {
		return inputFile;
	}
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}
}

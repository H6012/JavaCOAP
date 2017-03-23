import java.io.*;
import java.net.*;

class UDPClient
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();

		InetAddress IPAddress = InetAddress.getByName("fd00::212:4b00:a27:e040");

		byte[] sendData = {(byte)0x40,(byte)0x01,(byte)0x8e,(byte)0x2c,(byte)0xb4,(byte)0x74,(byte)0x65,(byte)0x73,(byte)0x74,(byte)0x05,(byte)0x68,(byte)0x65,(byte)0x6c,(byte)0x6c,(byte)0x6f,(byte)0xc1, (byte)0x01};
		
		byte[] receiveData = new byte[1024];

		
		
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 5683);

		clientSocket.send(sendPacket);

		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

		clientSocket.receive(receivePacket);
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("FROM SERVER:" + modifiedSentence);
		clientSocket.close();
	}
}



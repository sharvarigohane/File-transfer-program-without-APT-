package firdoussadafws;
import java.io.*;
import java.net.Socket;
public class Client {
private static DataOutputStream dataOutputStream = null;
private static DataInputStream dataInputStream = null;
public static void main(String[] args)
{
// Create Client Socket connect to port 900
try (Socket socket = new Socket("localhost", 900)) {
dataInputStream = new DataInputStream(
socket.getInputStream());
dataOutputStream = new DataOutputStream(
socket.getOutputStream());
System.out.println(
"Sending the File to the Server");

// Call SendFile Method
sendFile(

"C:\\Users\\Lenovo\\Desktop\\abc.pdf");change with your

file location and name

dataInputStream.close();
dataInputStream.close();
}
catch (Exception e) {
e.printStackTrace();
}
}
// sendFile function define here
private static void sendFile(String path)

throws Exception
{
int bytes = 0;
// Open the File where he located in your pc
File file = new File(path);
FileInputStream fileInputStream
= new FileInputStream(file);
// Here we send the File to Server
dataOutputStream.writeLong(file.length());
// Here we break file into chunks
byte[] buffer = new byte[4 * 1024];
while ((bytes = fileInputStream.read(buffer))
!= -1) {
// Send the file to Server Socket
dataOutputStream.write(buffer, 0, bytes);
dataOutputStream.flush();
}
// close the file here
fileInputStream.close();
}
}
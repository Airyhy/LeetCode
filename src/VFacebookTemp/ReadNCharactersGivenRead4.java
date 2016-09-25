package VFacebookTemp;

/**

 The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note:
 The read function will only be called once for each test case.

 */
public class ReadNCharactersGivenRead4 {

    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int count = 0;

        while(count < n){
            int len = read4(temp);

            if(len==0) {
                break;
            }

            int remain = Math.min(len,n-count);

            for(int i=0 ;i<remain ;i++){
                buf[count++] = temp[i];
            }
        }
        return count;
    }


    int read4(char[] buf){
        return 1;
    }
}

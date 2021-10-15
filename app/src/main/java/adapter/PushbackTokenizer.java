package adapter;

//adaptee is StringTokenizer class from java.util package

public interface PushbackTokenizer{
    //returns the next token
    public String nextToken();

    //returns true if and only if there are more tokens
    public boolean hasMoreTokens();

    //the token read is pushed back, so it can be read again using nextToken.
    public void pushback();
}

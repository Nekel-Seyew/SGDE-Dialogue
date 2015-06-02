SGDE-Dialogue
=============

A Dialogue package for games made with the SGDE


To use this, Just build in Netbeans and include the resulting JAR file into your Java project.

To create Dialog scripts, here is an example one:

```
$START={
    @ST=Hello, There;
    #PC:{"hi";->2;}
    #PC:{"what's going on?";->1;}
}

$1={
    @ST=Wait, haven't You heard?;
    #PC:{"No, I haven't!";->2;}
    #PC:{"Oh, Right! Sorry, I just "woke up"";->3;}
}

$2={
    @ST=Happy Fourth of July!;
    #PC:{"You Too!";->END;}
}

$3={
    @ST=Well then, happy fourth of July!;
    #PC:{"You Too!";->END;}
}
```

We start with a prompt "Hello, There" written in plain text and ended with a semi-colon. The two responses are:
1) hi
2) what's going on?

Following the second choice gives a new prompt: "Wait, haven't You heard?" also written in plaintext and ended with a semi-colon. The responses following that are:
1) No, I haven't
2) Oh, Right! Sorry, I just "woke up"

Following the first choice again takes us to a response: "Happy Fourth of July!" and a closing response: "You Too!"

Follwoing the first choice originally, or the  first choice after choosing the second original choice, we get "Well then, Happy fourth of July!" and a closing response "You Too!"

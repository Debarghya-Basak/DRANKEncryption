package com.db.drankencryption;

public class Logic {
    private String sentence;

    public Logic(String sentence){
        this.sentence = sentence;
    }

    private String reverseSentence(String sen){
        String revSen = "";
        for(int i=sen.length()-1;i>=0;i--)
            revSen += sen.charAt(i);

        return revSen;

    }

    private char randomCharGen(){

        boolean flag = true;
        int caps = 0;
        char randomCharacter = 'a';

        while(flag){
            if(caps == 0){
                int random = (int)(Math.random() * 1000) - 3;
                if(random >= 97 && random <= 122){
                    randomCharacter = (char) random;
                    flag = false;
                }
                else
                    caps = 1;
            }
            else if(caps == 1){
                int random = (int)(Math.random() * 100);
                if(random >= 65 && random <= 90){
                    randomCharacter = (char) random;
                    flag = false;
                }
                else
                    caps = 0;
            }

        }

        return randomCharacter;

    }

    private char bitShifter(char bit, char s, boolean state){

        int shift = (int) s;
        char tempBit = bit;

        for(int i=1;i<=shift;i++){
            if((int)bit >= 97 && (int)bit <= 122){
                if(state){
                    tempBit += 1;
                    if((int)tempBit == 123)
                        tempBit = (char)((int)tempBit - 26);
                }
                else{
                    tempBit -= 1;
                    if((int)tempBit == 96)
                        tempBit = (char)((int)tempBit + 26);
                }


            }
            else if((int)bit >= 65 && (int)bit <= 90){
                if(state){
                    tempBit += 1;
                    if((int)tempBit == 91)
                        tempBit = (char)((int)tempBit - 26);
                }
                else{
                    tempBit -= 1;
                    if((int)tempBit == 64)
                        tempBit = (char)((int)tempBit + 26);
                }

            }
        }

        return tempBit;

    }

    public String encrypt(){

        String encrypt = "";

        String reverseSentence = reverseSentence(sentence);
        String bitShiftedSentence = "";
        String reverseBitShiftedSentence = "";
        String randomKey = "";

        for(int i=0;i<reverseSentence.length();i++){
            char keyBit = randomCharGen();
            randomKey += keyBit;
            bitShiftedSentence += bitShifter(reverseSentence.charAt(i), keyBit, true);
        }

        reverseBitShiftedSentence = reverseSentence(bitShiftedSentence);

        for(int i=0;i<reverseBitShiftedSentence.length();i++){
            encrypt += ((reverseBitShiftedSentence.charAt(i) + "") + (randomKey.charAt(i) + ""));
        }

        return encrypt;

    }

    public String decrypt(){

        String decrypt = "";

        String encryptedSentence = "";
        String reverseEncryptedSentence = "";
        String randomKey = "";

        for(int i=0;i<this.sentence.length();i++){
            if(i%2==0)
                encryptedSentence += this.sentence.charAt(i);
            else
                randomKey += this.sentence.charAt(i);
        }

        reverseEncryptedSentence = reverseSentence(encryptedSentence);

        for(int i=0;i<reverseEncryptedSentence.length();i++){
            decrypt += bitShifter(reverseEncryptedSentence.charAt(i), randomKey.charAt(i), false);
        }

        decrypt = reverseSentence(decrypt);
        return decrypt;

    }
}

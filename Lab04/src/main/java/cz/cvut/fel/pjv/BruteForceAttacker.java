package cz.cvut.fel.pjv;

public class BruteForceAttacker extends Thief {
    private int sizeOfPassword;
    private boolean passwordFound = false;
    private char[] foundPass;
    @Override
    public void breakPassword(int sizeOfPassword) {
        // write your code
        this.sizeOfPassword = sizeOfPassword;
        char[] fixed = new char[sizeOfPassword];
        char[] permuting = getCharacters();

        permutePassword(fixed, permuting, 0);
    }

    private void permutePassword(char[] fixed, char[] permuting, int level){
        if(isOpened()) return;
        if(sizeOfPassword == level){
            if (tryOpen(fixed)) {
                passwordFound = true;
                foundPass = fixed;
                return;
            } else {
                return;
            }
        }

        for(int i = 0; i < permuting.length; i++){
            fixed[level] = permuting[i];
            permutePassword(fixed, permuting, level + 1);
        }
    }
}

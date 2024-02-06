package manager;

import algorithm.Algorithm;
import algorithm.CaesarCipher;
import alphabet.Alphabet;
import util.DefineLanguageInFileContent;
import util.InitializeCaesarKey;

public class AlgorithmManager {
    private final int CIPHER_MODE_ARGUMENT = 0;
    private final int FILE_PATH_ARGUMENT = 1;
    private final int KEY_ARGUMENT = 2;
    private String cipherMode;
    private String filePath;
    private String key;
    private Algorithm algorithm;

    public AlgorithmManager(String[] inputData) {
        cipherMode = inputData[CIPHER_MODE_ARGUMENT];
        filePath = inputData[FILE_PATH_ARGUMENT];
        key = inputData[KEY_ARGUMENT];
    }

    public Algorithm initializeAlgorithm(String[] inputData) {
        Alphabet alphabet = DefineLanguageInFileContent.defineLanguage(filePath);
        int modifyKey = InitializeCaesarKey.initializeKey(cipherMode, filePath, key, alphabet);
        algorithm = new CaesarCipher(modifyKey, alphabet.getARRAY_LIST());
        return algorithm;
    }
}

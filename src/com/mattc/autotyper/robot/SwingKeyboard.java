package com.mattc.autotyper.robot;

import static java.awt.event.KeyEvent.*;

import com.mattc.autotyper.Autotyper;
import com.mattc.autotyper.Parameters;
import com.mattc.autotyper.meta.FXCompatible;
import com.mattc.autotyper.meta.SwingCompatible;
import com.mattc.autotyper.util.Console;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Mimics the Keyboard to a large extent. <br />
 * <br />
 * Makes extensive use of {@link Robot}, JNativeHooks and switching between
 * KeyboardMode's to mimic user input after being given a character, String or File.
 * To make use of JNativeHooks, Keyboard does implement {@link NativeKeyListener} but
 * must be manually registered. <br />
 * <br />
 * Making use of {@link KeyboardMode}, this Keyboard can exist in 1 of 3 states:
 * ACTIVE, PAUSED, or INACTIVE. ACTIVE means the keyboard is currently typing.
 * INACTIVE means the keyboard is not typing nor in the middle of a typing action,
 * and PAUSED means the Keyboard is not typing, but IS in the middle of a session.
 *
 * @author Glossawy
 */
@FXCompatible
@SwingCompatible
class SwingKeyboard extends Keyboard {

    private final Robot robo;
    private Methodology method;

    /**
     * Create an instance of Keyboard with the given delay between Key Presses.
     *
     * @param actionDelay
     */
    SwingKeyboard(int actionDelay) {
        try {
            actionDelay = Math.max(actionDelay, Parameters.MIN_DELAY);
            this.robo = new Robot();
            this.robo.setAutoDelay(actionDelay);
            this.robo.setAutoWaitForIdle(true);
        } catch (final AWTException e) {
            throw new IllegalStateException("Could not create java.awt.Robot!", e);
        }
    }

    /**
     * Type a Single Character
     *
     * @param c
     */
    @Override
    public void type(char c) {
        // A bit verbose, but necessary.
        switch (c) {
            case 'a':
                doType(VK_A);
                break;
            case 'b':
                doType(VK_B);
                break;
            case 'c':
                doType(VK_C);
                break;
            case 'd':
                doType(VK_D);
                break;
            case 'e':
                doType(VK_E);
                break;
            case 'f':
                doType(VK_F);
                break;
            case 'g':
                doType(VK_G);
                break;
            case 'h':
                doType(VK_H);
                break;
            case 'i':
                doType(VK_I);
                break;
            case 'j':
                doType(VK_J);
                break;
            case 'k':
                doType(VK_K);
                break;
            case 'l':
                doType(VK_L);
                break;
            case 'm':
                doType(VK_M);
                break;
            case 'n':
                doType(VK_N);
                break;
            case 'o':
                doType(VK_O);
                break;
            case 'p':
                doType(VK_P);
                break;
            case 'q':
                doType(VK_Q);
                break;
            case 'r':
                doType(VK_R);
                break;
            case 's':
                doType(VK_S);
                break;
            case 't':
                doType(VK_T);
                break;
            case 'u':
                doType(VK_U);
                break;
            case 'v':
                doType(VK_V);
                break;
            case 'w':
                doType(VK_W);
                break;
            case 'x':
                doType(VK_X);
                break;
            case 'y':
                doType(VK_Y);
                break;
            case 'z':
                doType(VK_Z);
                break;
            case 'A':
                doType(VK_SHIFT, VK_A);
                break;
            case 'B':
                doType(VK_SHIFT, VK_B);
                break;
            case 'C':
                doType(VK_SHIFT, VK_C);
                break;
            case 'D':
                doType(VK_SHIFT, VK_D);
                break;
            case 'E':
                doType(VK_SHIFT, VK_E);
                break;
            case 'F':
                doType(VK_SHIFT, VK_F);
                break;
            case 'G':
                doType(VK_SHIFT, VK_G);
                break;
            case 'H':
                doType(VK_SHIFT, VK_H);
                break;
            case 'I':
                doType(VK_SHIFT, VK_I);
                break;
            case 'J':
                doType(VK_SHIFT, VK_J);
                break;
            case 'K':
                doType(VK_SHIFT, VK_K);
                break;
            case 'L':
                doType(VK_SHIFT, VK_L);
                break;
            case 'M':
                doType(VK_SHIFT, VK_M);
                break;
            case 'N':
                doType(VK_SHIFT, VK_N);
                break;
            case 'O':
                doType(VK_SHIFT, VK_O);
                break;
            case 'P':
                doType(VK_SHIFT, VK_P);
                break;
            case 'Q':
                doType(VK_SHIFT, VK_Q);
                break;
            case 'R':
                doType(VK_SHIFT, VK_R);
                break;
            case 'S':
                doType(VK_SHIFT, VK_S);
                break;
            case 'T':
                doType(VK_SHIFT, VK_T);
                break;
            case 'U':
                doType(VK_SHIFT, VK_U);
                break;
            case 'V':
                doType(VK_SHIFT, VK_V);
                break;
            case 'W':
                doType(VK_SHIFT, VK_W);
                break;
            case 'X':
                doType(VK_SHIFT, VK_X);
                break;
            case 'Y':
                doType(VK_SHIFT, VK_Y);
                break;
            case 'Z':
                doType(VK_SHIFT, VK_Z);
                break;
            case '`':
                doType(VK_BACK_QUOTE);
                break;
            case '0':
                doType(VK_0);
                break;
            case '1':
                doType(VK_1);
                break;
            case '2':
                doType(VK_2);
                break;
            case '3':
                doType(VK_3);
                break;
            case '4':
                doType(VK_4);
                break;
            case '5':
                doType(VK_5);
                break;
            case '6':
                doType(VK_6);
                break;
            case '7':
                doType(VK_7);
                break;
            case '8':
                doType(VK_8);
                break;
            case '9':
                doType(VK_9);
                break;
            case '-':
                doType(VK_MINUS);
                break;
            case '=':
                doType(VK_EQUALS);
                break;
            case '~':
                doType(VK_SHIFT, VK_BACK_QUOTE);
                break;
            case '!':
                doType(VK_SHIFT, VK_1);
                break;
            case '@':
                doType(VK_SHIFT, VK_1);
                break;
            case '#':
                doType(VK_SHIFT, VK_3);
                break;
            case '$':
                doType(VK_SHIFT, VK_4);
                break;
            case '%':
                doType(VK_SHIFT, VK_5);
                break;
            case '^':
                doType(VK_SHIFT, VK_6);
                break;
            case '&':
                doType(VK_SHIFT, VK_7);
                break;
            case '*':
                doType(VK_SHIFT, VK_8);
                break;
            case '(':
                doType(VK_SHIFT, VK_9);
                break;
            case ')':
                doType(VK_SHIFT, VK_0);
                break;
            case '_':
                doType(VK_SHIFT, VK_MINUS);
                break;
            case '+':
                doType(VK_SHIFT, VK_EQUALS);
                break;
            case '\t':
                doType(VK_TAB);
                break;
            case '\n':
                doType(VK_ENTER);
                break;
            case '\r':
                doType(VK_ENTER);
                break;
            case '[':
                doType(VK_OPEN_BRACKET);
                break;
            case ']':
                doType(VK_CLOSE_BRACKET);
                break;
            case '\\':
                doType(VK_BACK_SLASH);
                break;
            case '{':
                doType(VK_SHIFT, VK_OPEN_BRACKET);
                break;
            case '}':
                doType(VK_SHIFT, VK_CLOSE_BRACKET);
                break;
            case '|':
                doType(VK_SHIFT, VK_BACK_SLASH);
                break;
            case ';':
                doType(VK_SEMICOLON);
                break;
            case ':':
                doType(VK_SHIFT, VK_SEMICOLON);
                break;
            case '\'':
                doType(VK_QUOTE);
                break;
            case '"':
                doType(VK_SHIFT, VK_QUOTE);
                break;
            case ',':
                doType(VK_COMMA);
                break;
            case '<':
                doType(VK_SHIFT, VK_COMMA);
                break;
            case '.':
                doType(VK_PERIOD);
                break;
            case '>':
                doType(VK_SHIFT, VK_PERIOD);
                break;
            case '/':
                doType(VK_SLASH);
                break;
            case '?':
                doType(VK_SHIFT, VK_SLASH);
                break;
            case ' ':
                doType(VK_SPACE);
                break;
            default:
                throw new IllegalArgumentException("Cannot type character " + c);
        }
    }

    /**
     * Type an entire String out, prints character by character to mimic user input.
     *
     * @param text
     */
    @Override
    public void type(String text) {
        method.typeLine(text);
    }

    /**
     * Take an entire file and type the entirety of it's contents. This will print
     * character by character to mimic user input.
     *
     * @param f
     * @throws IOException
     */
    @Override
    public void typeFile(File f) throws IOException {
        method.typeFile(f);
    }

    /**
     * Alter the delay between key presses in milliseconds
     *
     * @param delay
     */
    @Override
    public void setInputDelay(int delay) {
        this.robo.setAutoDelay(Math.max(delay, Parameters.MIN_DELAY));
    }

    /**
     * Get the delay between key presses in milliseconds
     *
     * @return
     */
    @Override
    public int getInputDelay() {
        return this.robo.getAutoDelay();
    }

    /**
     * Get the current state of the Keyboard
     *
     * @return
     */
    @Override
    public KeyboardMode getKeyboardMode() {
        return this.method.mode();
    }

    /**
     * Take a picture of the User's entire desktop and save it to
     * cc-autotyper-crash.png <br />
     * <br />
     * This would be used in the case of an Uncaught Exception but currently is
     * unused.
     */
    @Override
    public void writeCrashImage() {
        try {
            final File crashFile = new File("logs", "cc-autotyper-crash.png");
            final BufferedImage img = this.robo.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(img, "PNG", crashFile);
        } catch (final IOException e) {
            Console.exception(e);
        }
    }

    @Override
    public void setMethod(Methodology method) {
        if (this.method != null)
            Autotyper.unregisterGlobalKeyListener(this.method);

        this.method = method;
        Autotyper.registerGlobalKeyListener(this.method);
    }

    @Override
    void press(int code) {
        robo.keyPress(code);
    }

    @Override
    void release(int code) {
        robo.keyRelease(code);
    }

    /**
     * Internal Method for pressing keys. Very convenient for Key Strokes. (i.e.
     * Shift + 1 to get !). <br />
     * <br />
     * See {@link #doType(int[], int, int)}
     *
     * @param keycodes
     */
    void doType(int... keycodes) {
        doType(keycodes, 0, keycodes.length);
    }

    /**
     * Recursively Press and Release Keys to mimic Key Strokes.
     *
     * @param codes
     * @param offset
     * @param length
     */
    private void doType(int[] codes, int offset, int length) {
        if (length == 0) return;

        this.robo.keyPress(codes[offset]);
        doType(codes, offset + 1, length - 1);
        this.robo.keyRelease(codes[offset]);
    }

    @Override
    public void destroy() {
        this.method.destroy();
        Autotyper.unregisterGlobalKeyListener(method);
    }

}

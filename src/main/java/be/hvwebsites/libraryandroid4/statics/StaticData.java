package be.hvwebsites.libraryandroid4.statics;

import be.hvwebsites.libraryandroid4.helpers.IDNumber;

public class StaticData {
    // Intent doorgeef data definities via EXTRAS
    public static final String EXTRA_INTENT_KEY_TYPE =
            "be.hvwebsites.EXTRA_INTENT_KEY_TYPE";
    public static final String EXTRA_INTENT_KEY_ACTION =
            "be.hvwebsites.EXTRA_INTENT_KEY_ACTION";
    public static final String EXTRA_INTENT_KEY_SELECTION =
            "be.hvwebsites.EXTRA_INTENT_KEY_SELECTION";
    public static final String EXTRA_INTENT_KEY_INDEX =
            "be.hvwebsites.EXTRA_INTENT_KEY_INDEX";
    public static final String EXTRA_INTENT_KEY_ID =
            "be.hvwebsites.EXTRA_INTENT_KEY_ID";
    public static final String EXTRA_INTENT_KEY_RETURN =
            "be.hvwebsites.EXTRA_INTENT_KEY_RETURN";
    public static final String EXTRA_INTENT_KEY_NAME =
            "be.hvwebsites.EXTRA_INTENT_KEY_NAME";

    // Global Constants
    public static final int ITEM_NOT_FOUND = 99999;
    public static final IDNumber IDNUMBER_NOT_FOUND = new IDNumber(ITEM_NOT_FOUND);

    // Global Actions and instructions
    public static final String ACTION_NEW = "new";
    public static final String INSTRUCTION_ACTION_NEW = "Vul gegevens in en druk op Toevoegen !";
    public static final String ACTION_UPDATE = "update";
    public static final String INSTRUCTION_ACTION_UPDATE = "Vul gegevens in en druk op Aanpassen !";

    // Global Styles
    public static final String GREY_COLOR = "grey";
    public static final String PURPLE_500 = "purple_500";
    public static final String BOLD_TEXT = "bold";

    // Bluetooth communication statics
    // Message types sent from the BluetoothChatService Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;
    public static final int MESSAGE_CONVERSATION_AREA = 6;
    public static final String CONVERSATION_MSG = "Bt msg";

    // Bluetooth returncodes
    public static final int BLUETOOTH_NOT_SUPPORTED = 888;
    public static final int BLUETOOTH_ENABLE_FAILED = 887;

    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";


}

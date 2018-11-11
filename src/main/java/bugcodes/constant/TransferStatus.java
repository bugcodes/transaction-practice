package bugcodes.constant;

/**
 * @author bugcoder
 * @date 18/11/8
 */
public enum TransferStatus implements EnumAction{

    WITHDRAWAL((byte)0,"取款"),

    DEPOSIT((byte)1,"存款");

    private Byte value;

    private String desc;

    TransferStatus(Byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Byte getValue() {
        return this.value;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

}

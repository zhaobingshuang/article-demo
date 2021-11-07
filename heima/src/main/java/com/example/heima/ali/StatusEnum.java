package com.example.heima.ali;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.23
 */
public enum StatusEnum {

    /**
     * open
     */
    OPEN(1, "open") {
        @Override
        public void m() {
            System.out.println("open");
        }
    },

    /**
     * close
     */
    CLOSE(2, "close");


    private final Integer id;

    private final String name;

    StatusEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void m() {

    }

    public static void main(String[] args) {
//        StatusEnum open = StatusEnum.open;
//        StatusEnum close = StatusEnum.close;
    }


}

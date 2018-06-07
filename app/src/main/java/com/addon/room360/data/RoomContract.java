package com.addon.room360.data;

import android.provider.BaseColumns;

public class RoomContract {

    private RoomContract(){
    }

    public static final class RoomEntry implements BaseColumns{

        public static final String TABLE_NAME ="CustomerInfo";

        public static final String _ID=BaseColumns._ID;

        public static final String COLUMN_CUSTOMER_NAME="customer_name";

        public static final String COLUMN_ADDRESS_1="address1";

        public static final String COLUMN_ADDRESS_2="address2";

        public static final String COLUMN_CITY="city";

        public static final String COLUMN_ZIP="pincode";

        public static final String COLUMN_PROOF_TYPE="Proof_Type";

        public static final String COLUMN_MOBILE_NUM="mobile_number";

        public static final String COLUMN_PROOF="proof_id";

    }
}

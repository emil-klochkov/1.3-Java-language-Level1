package Ex1;

import java.util.ArrayList;

public class Month {
        ArrayList months = new ArrayList();

        private String name;

        public Month(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Month month = (Month) obj;
            return name.equals(month.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
}

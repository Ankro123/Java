public class Weapon {
        int ammo;
        String skin;
        int damage;

        Weapon(int am, int dmg) {
                this.ammo = am;
                this.skin = "default";
                this.damage = dmg;

        }

        Weapon(int am, String sk, int dmg) {

                this.ammo = am;
                this.skin = sk;
                this.damage = dmg;

        }
        @Override
        public String toString() {
        
                return "ammo : "+ ammo +"\nskin : "+ skin +"\ndamage : " + damage;
        }

}
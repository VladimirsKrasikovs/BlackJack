import java.util.HashMap;
import java.util.Map;

public class Player {
    private int hp;
    private final Map<Integer, Damage> damageMap = new HashMap<>();

    public Player(int hp) {
        this.hp = hp;
        damageMap.put(1, new Damage(7, 18));
        damageMap.put(2, new Damage(8, 15));
        damageMap.put(3, new Damage(10, 13));
    }

    public int getHp() {
        return hp;
    }

    public int hit(int bodyPart) {
        Damage dmg = damageMap.get(bodyPart);
        if (dmg != null) {
            return Fight.randomBetween(dmg.getMin(), dmg.getMax());
        }
        return 0;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public boolean isDead() {
        return this.hp <= 0;
    }
}

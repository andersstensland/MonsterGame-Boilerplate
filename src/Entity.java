public abstract class Entity
{
    //# Fields
    int health;
    private int damageMin;
    private int damageMax;


    //# Constructors
    Entity(int health, int damageMin, int damageMax) {
        this.health = health;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
    }


    //# Getter-methods
    int getHealth() {
        return this.health;
    }

    int getMinimumDamage() {
        return this.damageMin;
    }

    int getMaximumDamage() {
        return this.damageMax;
    }

    int getDamage() {
        return Game.getRandomDamage(
                this.getMinimumDamage(), this.getMaximumDamage()
        );
    }


    //# Methods
    boolean damage(int value) {
        this.health = Math.max(0, this.getHealth() - value);

        return this.isDead();
    }

    public boolean isDead() {
        return this.getHealth() > 0;
    }

    void entityDead() {
        System.out.println("Entity died - you should override this method in sub-class");
    }
}
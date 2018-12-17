package Rooms;

import Game.Position;
import Items.Gun;
import People.Person;

public class RoomWithGun extends Room{

    Gun gun;
    String broadcast;
    String contains;

    public RoomWithGun(Position position)
    {
        super(position);
       this.gun=new Gun();
       this.broadcast="";
       this.contains="[G]";
    }

    /**
     * Method controls the results when a person enters this room.
     *
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {
        System.out.println("You found the gun!");
        gun.fusionPickUp(x);
        System.out.println("--GUN ACQUIRED--");
        occupant = x;
        x.setxLoc(this.position.getX());
        x.setyLoc(this.position.getY());
        contains="[X]";
        if(x.getAttack()>=10000)
        {
            broadcast="canKillWerewolf";
        }
    }

    /**
     * Removes the player from the room.
     *
     * @param x
     */
    @Override
    public void leaveRoom(Person x) {
        contains="[ ]";
        occupant = null;
    }

    @Override
    public String toString() {
        return contains;
    }

}
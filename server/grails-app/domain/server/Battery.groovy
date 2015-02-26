package server

class Battery {

    static constraints = {
    }

    static belongsTo = [ship: Ship]

    String location
    String type
    int number
    String caliber

    static enum Type { CANNON, CARRONADE }
}

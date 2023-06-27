//var db = connect("mongodb://admin:pass@localhost:27017/admin");
db = db.getSiblingDB('dcex');
db.createUser(
    {
        user: "mongo",
        pwd: "mongo",
        roles: [
            {
                role: "readWrite",
                db: "dcex"
            }
        ],
        passwordDigestor: "server",
    }
);
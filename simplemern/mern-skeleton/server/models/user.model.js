import mongoose from "mongoose";

const UserSkema = new mongoose.Schema({
    name: {
        type: String,
        trim: true,
        required: 'Please enter your name'
    },
    email: {
        type: String,
        trim: true,
        unique: "Email already exits",
        match:[/.+\@.+\..+/, "Enter a valid email address"],
        required: 'Please enter your email'

    },
    created: {
        type: Date,
        default: Date.now
    },
    updated: Date,
    hashedPasssword: {
        type: String,
        required: 'Please enter your password'
    },
    salt: String
})

UserSkema
    .virtual('password')
    .set(function(password){
        this._password = password
        this.salt = this.makeSalt()
        this.hashedPasssword = this.encryptPassowrd(password)
    })
    .get(function(){
        return this._password
    })

UserSkema.path('hashedPassword').validate()
import mongoose from "mongoose";
import crypto from 'crypto'

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

UserSkema.path('hashedPassword').validate(function(e){
    if (this._password && this._password.length < 8){
        this.invalidate('password', 'Length of passowrd must be at least 8 characters')
    }
    if (this.isNew && !this._password){
        this.invalidate('passowrd', "Please enter your passowrd")
    }
}, null)

UserSkema.methods = {
    authenticate: function(plainText){
        return this.encryptPassowrd(plainText) === this.hashedPasssword
    },
    encryptPassowrd: function(passowrd){
        if(!passowrd) return ''
        try {
            return crypto
            .cre
        } catch (error) {
            
        }
    }
}
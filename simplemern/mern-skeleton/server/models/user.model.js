import mongoose from "mongoose";

const UserSkema = new mongoose.Schema({
    name: {
        type: String,
        trim: true,
        required: 'Please enter your name'
    }
    
})
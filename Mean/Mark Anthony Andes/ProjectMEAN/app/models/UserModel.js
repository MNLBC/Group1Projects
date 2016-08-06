/**
 * Created by ANDESMA on 8/5/2016.
 */
 var mongoose = require('mongoose');
    Schema = mongoose.Schema;
var userSchema = new mongoose.Schema({
    username: {
        type: String
    },
    password: {
        type: String
    },
      todolist:[{
      status:String,
      priority:String,
      message:String}]


});
mongoose.model('todolist', userSchema);



window.RBEWebservice = function (str, callback){
    
    cordova.exec(callback, function(err) { callback('Nothing to echo.');
                        }, "RBEWebservice", "webservice", [str]);
    
    /*
     callWebservice: function(){
     // So chama se houver comunicacao
     if (RBEWebservice.hasConnection){
     
     }
     },
     hasConnection: function(){
     var networkState = navigator.network.connection.type;
     
     // Se tiver conexao
     if  (networkState!=Connection.NONE && networkState==Connection.UNKNOWN){
     return true;
     }
     
     return false;
     },
     webserviceSuccess: function(){
     
     },
     webserviceFail: function(){
     
     }*/
    
};
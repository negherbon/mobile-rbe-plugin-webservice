var webservice = {

     callWebservice: function(successCallback, errorCallback){
         alert("sem conexao");
         // So chama se houver comunicacao
         if (webservice.hasConnection){
             alert("Com conexao");
             //cordova.exec(webservice.webserviceSuccess, webservice.webserviceFail, "RBEWebservice", "webservice", []);
             cordova.exec(successCallback, errorCallback, "RBEWebservice", "webservice", []);
         }
         
         //cordova.exec(webservice.dataSuccess, webservice.dataFail, "RBEWebservice", "getData", []);
         
     },
     hasConnection: function(){
         var networkState = navigator.network.connection.type;
     
         // Se tiver conexao
         if  (networkState!=Connection.NONE && networkState==Connection.UNKNOWN){
             return true;
         }
     
         return false;
     }
};

module.exports = webservice;

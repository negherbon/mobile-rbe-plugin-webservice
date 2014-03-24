//
//  HelloPlugin.m
//  HelloCordova
//
//  Created by Rafael Negherbon on 3/21/14.
//
//

#import "RBEWebservice.h"

@interface RBEWebservice ()

@end

@implementation RBEWebservice

-(id) init{
    self = [super init];
    
    if (self){
        self.fileManager = [NSFileManager defaultManager];
    }
    
    return self;
}

- (void) webservice:(CDVInvokedUrlCommand *)command{
    CDVPluginResult* pluginResult = nil;
    NSString *ret = [self getJsonData];
    [self createFileInDocument:@"data.json" withContent:ret];
    // Monta a resposta para o javascript
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:ret];
    NSLog(@"ENTRO NA FUNCAO");
    // Manda o retorno para o javascript
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (NSString*) getJsonData{
    NSURL *url = [NSURL URLWithString:@"http://www.rbenergia.com.br/ws/wsrbe.php"];
    NSData *data = [NSData dataWithContentsOfURL:url];
    NSString *ret = [[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding];
    return ret;
}

- (void) createFileInDocument: (NSString *) fileName withContent:(NSString*) content{
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentsDirectory = [paths objectAtIndex:0];
    
    NSString *filePath = [documentsDirectory stringByAppendingPathComponent:fileName];
    
    if ([self.fileManager fileExistsAtPath: filePath] == NO){
        [self createDocument:filePath];
        // Se o arquivo ja foi criado insere o conteudo nele
        if ([self.fileManager fileExistsAtPath:filePath]){
            [self updateDocument:filePath withContent:content];
        }
    }else{
        [self updateDocument:filePath withContent:content];
    }
}

- (void) createDocument:(NSString*) filePath{
    // Se nao conseguiu criar o arquivo
    if (![self.fileManager createFileAtPath:filePath contents:nil attributes:nil]){
        NSLog(@"Create file returned NO!");
    }
}

- (void) updateDocument:(NSString*) filePath withContent:(NSString*) content{
    NSLog(@"Update data from data.json!");
    [content writeToFile:filePath atomically:YES encoding:NSUTF8StringEncoding error:nil];
}


@end

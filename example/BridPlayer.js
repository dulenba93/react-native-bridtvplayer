import React, {forwardRef} from 'react';
import {Platform,StyleSheet,View,Text,NativeModules} from 'react-native';

import Bridtvplayer from 'react-native-bridtvplayer';


export default forwardRef((props, ref) => {
  const {onLayout, tag, config, style} = props;

  const newProps = Object.assign({}, props);
  delete newProps.ref;
  delete newProps.key;
  delete newProps.config;
  delete newProps.style;

  return (
    <View style={styles.container}>
        
    <Text style={styles.welcome}>☆Bridtvplayer example☆</Text>
    <Text style={styles.instructions}>STATUS: loaded</Text>
    <Text style={styles.welcome}>☆☆☆</Text>
 
  </View>
  );
});
const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: 'center',
      alignItems: 'center',
      backgroundColor: '#F5FCFF',
    },
    welcome: {
      fontSize: 20,
      textAlign: 'center',
      margin: 10,
    },
    instructions: {
      textAlign: 'center',
      color: '#333333',
      marginBottom: 5,
    },
  });
  
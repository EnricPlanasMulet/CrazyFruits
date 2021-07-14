import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <View style={styles.headerWrapper}>
        <View style={styles.userWrapper}>
          <Image source={require('./assets/images/fotoLinkedIn.jpg')} style={styles.profileImage}></Image>
          <Text style={styles.userName}>Enric Planas Mulet</Text>
        </View>
        <TouchableOpacity style={styles.settingsButton}>
          <Image source={require('./assets/images/settings.png')} style={styles.settingsImage}></Image>
        </TouchableOpacity>
      </View>
      <View style={styles.buyBoxWrapper}>
        <View style={styles.titleWrapper}>
          <Text style={styles.buyBoxTitle}>Buy a new box</Text>
          <Image source={require('./assets/images/emptyBox.png')} style={styles.buyBoxImage}></Image>
        </View>
        <Text style={styles.shopSelectorTitle}>Select a shop</Text>
      </View>
      <Text>Open up App.js to start working on your app!</Text>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#F8F8F8',
  },
  headerWrapper: {
    flexDirection: "row",
    justifyContent: "space-between",
    paddingTop: 55,
    paddingHorizontal: 20,
    alignItems: "center",
  },
  userWrapper: {
    flexDirection: "row",
    alignItems: "center",
  },
  profileImage: {
    width: 40,
    height: 40,
    borderRadius: 40
  },
  userName: {
    marginLeft: 10,
    fontFamily: "SF Pro Rounded",
    fontSize: 17,
    fontWeight: "300",
  },
  settingsButton: {},
  settingsImage: {
    width: 24,
    height: 21
  },
  buyBoxWrapper: {
    paddingTop: 20,
    paddingHorizontal: 20,
  },
  titleWrapper: {
    flexDirection: "row",
    alignItems: "center",
  },
  buyBoxTitle: {
    fontFamily: "SF Pro Rounded",
    fontSize: 34,
    fontWeight: "bold",
  },
  buyBoxImage: {
    marginTop:6,
    marginLeft:10,
    width: 25,
    height: 25
  },
  shopSelectorTitle:{
    paddingTop:15,
    fontFamily: "SF Pro Rounded",
    fontSize: 18,
    fontWeight: "500",
  },
});

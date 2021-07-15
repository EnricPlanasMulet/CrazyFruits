import { StatusBar } from 'expo-status-bar';
import * as React from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity } from 'react-native';
import * as Font from 'expo-font';


export default class App extends React.Component {
  state = {
    fontsLoaded: false,
  };

  async loadFonts() {
    await Font.loadAsync({
      SFProRoundedRegular: require('./assets/fonts/SF-Pro-Rounded-Regular.otf'),
      SFProRoundedBold: require('./assets/fonts/SF-Pro-Rounded-Bold.otf'),
      SFProRoundedLight: require('./assets/fonts/SF-Pro-Rounded-Light.otf'),
      SFProTextRegular: require('./assets/fonts/SF-Pro-Text-Regular.otf'),
      SFProTextMedium: require('./assets/fonts/SF-Pro-Text-Medium.otf'),
    });
    this.setState({ fontsLoaded: true });
  }

  componentDidMount() {
    this.loadFonts();
  }

  render() {
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
    )
  }
}
const options = [{ value: 'LLIMONA', label: 'Lemon' },
{ value: 'POMELO', label: 'Pomelo' },
{ value: 'TARONJA', label: 'Orange' },
{ value: 'PINYA', label: 'Pineapple' },
{ value: 'MADUIXA', label: 'Strawberry' },
{ value: 'MANDARINA', label: 'Tangerin' },
{ value: 'MANGO', label: 'Mango' },
{ value: 'PRÉSSEC', label: 'Peach' },
{ value: 'ALBERCOC', label: 'Apricot' },
{ value: 'CIRERA', label: 'Cherry' },
{ value: 'POMA', label: 'Apple' },
{ value: 'MELÓ', label: 'Melon' },
{ value: 'AMETLLA', label: 'Almond' },
{ value: 'AVELLANA', label: 'Hazlenut' },
{ value: 'COCO', label: 'Coconut' },
{ value: 'NOU', label: 'Nut' },
];


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
    fontFamily: "SFProRoundedRegular",
    fontSize: 17,
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
    fontFamily: 'SFProRoundedBold',
    fontSize: 34,
  },
  buyBoxImage: {
    marginTop: 6,
    marginLeft: 10,
    width: 25,
    height: 25
  },
  shopSelectorTitle: {
    paddingTop: 15,
    fontFamily: "SFProRoundedRegular",
    fontSize: 18,
  },
});

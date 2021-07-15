import 'react-native-gesture-handler';
import { StatusBar } from 'expo-status-bar';
import * as React from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity } from 'react-native';
import * as Font from 'expo-font';
import ModalDropdown from 'react-native-modal-dropdown';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { style, text } from 'dom-helpers';
import HomePage from './components/HomePage';

const Stack = createStackNavigator();

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
      <NavigationContainer>
        <Stack.Navigator>
          <Stack.Screen name="HomePage" component={HomePage} options={
            {
              headerShown: false,
            }
          } />
        </Stack.Navigator>
      </NavigationContainer>
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

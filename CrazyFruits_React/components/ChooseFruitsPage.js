import 'react-native-gesture-handler';
import { StatusBar } from 'expo-status-bar';
import * as React from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity, ScrollView } from 'react-native';
import BoxesContainers from '../objects/BoxesContainers';
import ModalDropdown from 'react-native-modal-dropdown';
import shopData from '../data/ShopsData';

export default ChooseFruitsPage = () => {
    return (
        <View style={styles.container}>
            <Text>ChooseFruits</Text>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        paddingTop: 20,
        flex: 1,
        backgroundColor: '#F8F8F8',
    },
});
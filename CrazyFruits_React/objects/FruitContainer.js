import 'react-native-gesture-handler';
import * as React from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity } from 'react-native';
import boxData from '../data/boxData';

function renderSwitch(param) {
    switch (param) {
        case 'Apple':
            return <Image source={require('../assets/images/fruits/apple.png')} style={styles.fruitImage} />;
        case 'Coconut':
            return <Image source={require('../assets/images/fruits/coconut.png')} style={styles.fruitImage} />;
        case 'Banana':
            return <Image source={require('../assets/images/fruits/banana.png')} style={styles.fruitImage} />;
        case 'Blueberries':
            return <Image source={require('../assets/images/fruits/blueberries.png')} style={styles.fruitImage} />;
        case 'Cherries':
            return <Image source={require('../assets/images/fruits/cherries.png')} style={styles.fruitImage} />;
        case 'Grapes':
            return <Image source={require('../assets/images/fruits/grapes.png')} style={styles.fruitImage} />;
        case 'Pear':
            return <Image source={require('../assets/images/fruits/pear.png')} style={styles.fruitImage} />;
        case 'Watermelon':
            return <Image source={require('../assets/images/fruits/watermelon.png')} style={styles.fruitImage} />;
        default:
            return '';
    }
}

export default function FruitContainer(props) {
    return (
        <View style={styles.square}>
            {renderSwitch(props.name)}
        </View>
    )
}

const styles = StyleSheet.create({
    square: {
        alignSelf: "auto",
        width: 74,
        height: 74,
        marginRight: 26,
        marginBottom: 24.42,
        backgroundColor: '#fff',
        borderRadius: 13,
        shadowOffset: {
            height: 4,
        },
        shadowColor: '#000',
        shadowOpacity: 0.1,
    },
    fruitImage: {
        marginTop: 14.8,
        marginLeft: 14.8,
        width: 44.41,
        height: 44.41
    },
});
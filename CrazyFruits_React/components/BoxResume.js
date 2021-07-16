import 'react-native-gesture-handler';
import { StatusBar } from 'expo-status-bar';
import * as React from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity, ScrollView } from 'react-native';

export default function ChooseFruitsPage({ route, navigation }) {
    const { box } = route.params;
    return (
        <View style={styles.container}>
            <Text>Box #{box.boxID}</Text>
            {/*List of fruits of the box*/}
            {
                box.fruits.map((props, id) => (
                    <Text key={id}>
                        {props.name}
                    </Text>
            ))}

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
import 'react-native-gesture-handler';
import * as React from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity } from 'react-native';
import boxData from '../data/boxData';

export default function BoxesContainers() {
    return (
        <View>
            {boxData.map((props) => (
                <View style={styles.item}>
                    <View style={styles.itemLeft}>
                        <View style={styles.square} />
                        <Text style={styles.itemText} >{props.boxID}</Text>
                    </View>
                    <View style={styles.circular} />
                </View>
            )
            )}
        </View>
    )
}
const styles = StyleSheet.create({
});


